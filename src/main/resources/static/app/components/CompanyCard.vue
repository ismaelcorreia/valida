<template>
    <div class="card">
        <img :src="url" alt="logo" width="50">
        <h1>{{ title }}</h1>
        <p>{{ description }}</p>
    </div>
</template>
<script setup>
import { defineProps } from 'vue';

const props = defineProps({
    url: {
        type: String,
        required: true
    },
    title: {
        type: String,
        required: true
    },
    description: {
        type: String,
        default: 'No description provided.'
    }
});


</script>
<style scoped>
.card {
    border: 1px solid #540d689d;
    border-radius: 10px;
    padding: 10px;
    max-width: 350px;
    cursor: pointer;
    transition: box-shadow .4s;

    &:hover{
        box-shadow: 0 0 3px 3px #540d689d;
    }

    img {
        border-radius: 50%;
        margin-bottom: 20px;
    }

}
</style>
