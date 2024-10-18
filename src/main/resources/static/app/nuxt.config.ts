// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({

  head: {
    title: 'Valida',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' }
    ],
  },
  modules: ["@primevue/nuxt-module"],

  primevue: {
    options: {
      ripple: true,
      inputVariant: "filled",
      theme: {
        preset: 'Aura',
        options: {
          prefix: "p",
          darkModeSelector: "system",
          cssLayer: false,
        },
      },
    },
    components: {
        include: '*', 
    },
    directives: {
        include: '*', 
    },
  },

  css: ['~/assets/styles/main.scss'],
  compatibilityDate: "2024-04-03",
  devtools: { enabled: true },
});
