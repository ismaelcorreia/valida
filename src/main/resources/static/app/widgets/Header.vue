<template>
    <div class="header">
        <div class="title-header">
            <Logo/><h1>Valida🗹</h1>
        </div>
        <div class="actions-header">
            <span class="toggles" @click="themeAction">
                <span id="thToggle">
                    <i class="icon fi fi-sc-sun"></i>
                </span>
            </span>
        </div>
    </div>
</template>

<script setup >

import Logo from '/widgets/Logo.vue';

const themeAction = () => {
  const toggle = document.querySelector("#thToggle");
  const icon = toggle.querySelector(".icon");
  const htmlDOM = document.querySelector("html");
  toggle.classList.toggle("active"); 

  if (toggle.classList.contains("active")) {
    htmlDOM.classList.add("dark");
    icon.classList.add("fi-rr-moon-stars");
    icon.classList.remove("fi-rr-sun");
  } else {
    htmlDOM.classList.remove("dark");
    icon.classList.add("fi-rr-sun");
    icon.classList.remove("fi-rr-moon-stars");
  }
};
</script>
<style scoped lang="scss">
@import url('https://cdn-uicons.flaticon.com/2.6.0/uicons-regular-rounded/css/uicons-regular-rounded.css');

    .header{
        display: flex;
        align-items: center;
        justify-content: space-between;
        
        *{
            display: flex;
            align-items: center;
        }
    }
</style>