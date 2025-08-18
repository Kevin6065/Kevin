package com.course.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.course.dao.TodoDao;
import com.course.model.SearchCondition;
import com.course.model.TodoDto;
import com.course.model.TodoVo;

@Service
public class TodoService {
	
	private static final String UPLOAD_DIR = "/Workspace/Pictures";
	
	
	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	private TodoServiceHelper helper;
	
	public List<TodoVo> findAllTodo() {
		List<TodoDto> dtoList = todoDao.findAll();
		
		
		List<TodoVo> voList  = dtoList.stream().map(d -> helper.convertToVo(d)).collect(Collectors.toList());

		return voList;
	}
	
	
	public void addTodo(TodoVo todoVo) {
		// Vo -> Dto
		todoVo.setStatus("0");
		TodoDto dto = helper.convertToDto(todoVo);
		todoDao.add(dto);
		try {
			saveImage(todoVo.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteTodo(Long id) {
		todoDao.delete(id);
	}
	
	
	public TodoVo getTodoById(Long id) {
		TodoDto dto= todoDao.findById(id);
		return helper.convertToVo(dto);
	}

	public void editTodo(TodoVo todo) {
		TodoDto dto = helper.convertToDto(todo);
		todoDao.update(dto);
		
	}
	
	/**
	 * 寫入圖檔
	 * @param file
	 * @throws IOException
	 */
	private void saveImage(MultipartFile file) throws IOException {
		// 確保上傳目錄存在
		Path uploadPath = Paths.get(UPLOAD_DIR);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		// 保存檔案
		Path filePath = uploadPath.resolve(file.getOriginalFilename());
		// 如果檔案已經存在，直接覆蓋舊檔
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * 依條件搜尋
	 * @param condition
	 * @return
	 */
	public List<TodoVo> searchByCondition(SearchCondition condition) {
		List<TodoDto> dtoList = todoDao.findByCondition(condition);
		return dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
	}
	
	
}
