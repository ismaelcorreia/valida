<template>
  <input type="file" name="receipt" id="receipt" accept="application/pdf"  @change="onFileChange">
  <label for="receipt">

  <CompanyCard url="/bai.png" title="BAI" description="Carrega um comprovativo BAI DIRECTO" />
  </label>
</template>
<script setup>


const onFileChange = (event) => {
  const file = event.target.files[0];
  if (file && file.type === 'application/pdf') {
    fileName.value = file.name;
  } else {
    alert('Please select a valid PDF file.');
  }
};
</script>

<style scoped>

  #receipt{
    display: none;
  }

</style>