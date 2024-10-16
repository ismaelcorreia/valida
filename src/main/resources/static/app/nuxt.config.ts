// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  modules: ["@primevue/nuxt-module"],

  primevue: {
    options: {
      ripple: true,
      inputVariant: "filled",
      theme: {
        preset: Aura,
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
  compatibilityDate: "2024-04-03",
  devtools: { enabled: true },
});
