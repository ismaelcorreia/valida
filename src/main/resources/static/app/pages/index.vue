<template>
    <Header/>
    <div class="card-list">

        <BaiCard/>
    </div> 
    <ResponseCard/>
</template>

<script setup>
import Header from '/widgets/Header.vue'
</script>

<style scoped>
    .card-list{
        display: flex;
        width: 100%;
        align-items: center;
        justify-content: center;
    }

</style>