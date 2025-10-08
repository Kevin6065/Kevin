<template>
  <!-- <div id="terms-agreement"> -->
  <h2>使用條款</h2>
  <p>請閱讀以下條款並同意：</p>
  <textarea ref="textarea" v-model="terms" readonly></textarea>
  <div>
    <input type="checkbox" id="agree" v-model="isAgreed" />
    <label for="agree">我同意上述條款</label>
    <div :class="[activeClass, errorClass]">~~~</div>
  </div>
  <button :disabled="!isAgreed" @click="submit">提交</button>
  <!-- </div> -->
</template>

<script setup>
import { ref, onMounted } from 'vue'
const activeClass = ref('active')
const errorClass = ref('text-danger')
const isAgreed = ref(false)
const textarea = ref(null)
const terms = ref(`一、蒐集之目的：
     依就業服務法、雇主聘僱外國人許可及管理辦法及其他相關法規辦理外國人申請、引進...等，
     符合個人資料保護法之相關規定下，正當使用本人之個人資料。
    二、蒐集之個人資料類別：
     身份證上所登載之資料，如姓名、身分證字號、出生年月日、住址...等，詳如海內外相關
     主管機關、他國辦事處所需之業務申請書、文件、契約書等內容。
    三、個人資料利用之期間、地區、對象及方式：
    （一）期間：1.依據上開蒐集目的之存續期間；2.依相關法令規定或契約約定之保存年限。
    （二）地區：本公司所在地、與本公司有業務往來之海內外相關主管機關、他國辦事處所在地。
    （三）使用對象：本公司及本公司國內外分支機構、其他與本公司有業務往來之海內外相關主管
     機關、他國辦事處、依法有調查權機關或監理機關。
    （四）方式：以自動化機器或其他非自動化之利用方式（例如言詞、書面、電話、簡訊、電子郵
     件、傳真、電子文件、新聞雜誌、政府公報或網站公告等紙本或非紙本及其他合於
     當時科技之適當方式）或符合個人資料保護法第20條規定之利用。
    四、依據個資法第三條規定，台端就本公司保有台端之個人資料得行使下列權利：
    （一）得向本所查詢、請求閱覽或請求製給複製本。
    （二）得向本所請求補充或更正，惟依法台端應為適當之釋明。
    （三）得向本所請求停止蒐集、處理或利用及請求刪除，惟依法本所因執行業務所必須者，得不
    依台端請求為之。
    五、台端不提供個人資料所致權益之影響：
    （一）本公司是基於上述目的而須蒐集、處理或利用您的個人資料，若您不同意本公司蒐集、處
    理及利用您的個人資料，或是提供您的個人資料不完整，本公司將無法提供您最完善服務
    （包括但不限於最新折扣、優惠、活動新知、贈品、行銷資訊等），尚請見諒。
    六、個人資料之同意提供：
    （一）本人已充分了解上述告知事項、權利行使事項及注意事項之內容，且本公司、關係企業得
    依法變更或新增該內容，並以口頭、書面、電話、簡訊、電子郵件、傳真、電子文件、新
    聞雜誌、政府公報等方式或網站公告方式供您知悉及查閱。
    （二）同意本公司、關係企業得依上述告知事項，對您的個人資料為蒐集、處理及利用。
    `)

const adjustHeight = () => {
  textarea.value.style.height = 'auto' // 重置高度
  textarea.value.style.height = textarea.value.scrollHeight + 'px' // 設定為內容高度
}

onMounted(() => {
  adjustHeight() // 初始化時調整高度
})

const submit = () => {
  alert('您已成功提交！')
}
</script>

<style scoped>
#terms-agreement {
  max-width: 400px;
  margin: 20px auto;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

textarea {
  width: 100%;
  /* height: 60%vh; */
  /* 隱藏滾動條 */
  overflow: hidden;
  margin-bottom: 10px;
  resize: none;
}
</style>
