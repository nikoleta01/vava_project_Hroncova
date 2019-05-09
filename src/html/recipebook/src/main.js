import Vue from 'vue'
import App from './App.vue'
import store from './store'
import VueI18n from 'vue-i18n'
import VueResource from 'vue-resource'

Vue.use(VueI18n)
Vue.use(VueResource)

const messages = {
  en: {
    hello: 'Recipe Book',
    cat: {
      meal: 'Main meal',
      soup: 'Soup',
      dessert: 'Dessert',
      appetizer: 'Appetizer'
    },
    recipe: {
      ingredients: "Ingredients",
      directions: "Directions",
      servings: "Servings",
      prepTime: "Preparation time"
    }
  },
  sk: {
    hello: 'Kniha receptov',
    cat: {
      meal: 'Hlavný chod',
      soup: 'Polievka',
      dessert: 'Dezert',
      appetizer: 'Predjedlo'
    },
    recipe: {
      ingredients: "Ingrediencie",
      directions: "Postup",
      servings: "Počet porcií",
      prepTime: "Čas prípravy"
    }
  }
}

const i18n = new VueI18n({
  locale: 'sk',
  messages,
})

Vue.config.productionTip = false

new Vue({
  store,
  i18n,
  render: h => h(App)
}).$mount('#app')
