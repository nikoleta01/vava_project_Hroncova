<template>
  <div id="app">
    <div class="jumbotron">
      <h3>{{ $t('hello') }}</h3>
      <div class="form-group">
        <select class="form-control" v-model="$i18n.locale" style="max-width:80px; margin:auto">
          <option value="sk">SK</option>
          <option value="en">EN</option>
        </select>
        <hr>
        <div style="margin: auto">
          <div class="btn-group btn-group-lg">
            <button @click="appetizer" class="btn btn-info">{{ $t('cat.appetizer') }}</button>
            <button @click="soup" class="btn btn-info">{{ $t('cat.soup') }}</button>
            <button @click="meal" class="btn btn-info">{{ $t('cat.meal') }}</button>
            <button @click="dessert" class="btn btn-info">{{ $t('cat.dessert') }}</button>
          </div>
        </div>
      </div>
    </div>
    <br>

    <recipe-list :recipes="recipes" v-if="showList" @itemSelected="wasSelected"></recipe-list>
    <recipe v-else :recipe="recipe"></recipe>

    <!-- <div style="max-width: 1000px; margin: auto">
      <div v-for="(recipe, index) in recipes" :key=index style="cursor: pointer; padding: 20px" align="left">
        <img v-on:click="recipe.shown = true" height="100" width="150" :src="recipe.img" alt="Krtkova torta"> {{ recipe.name }}
        <br>
        <p>{{recipe.descr}}</p>
        <ul v-if="recipe.shown">
          <li v-for="(ord, i) in recipe.orders" :key="i">{{ord}}</li>
        </ul>
      </div>
    </div> -->
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import RecipeList from './components/RecipeList.vue'
import Recipe from './components/Recipe.vue'

export default {
  name: 'app',
  data () {
    return {
      showList: true,
      recipe: {},
      recipes: []
    }
  },
  components: {
    RecipeList,
    Recipe
  },
  methods: {
    fillRecipes() {

    },
    wasSelected(index) {
      this.recipe = this.recipes[index]
      this.showList = false;
    },
    appetizer() {
      this.$http.get('http://localhost:8080/nevimei/webapi/appetizers',{
          headers: {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          }
        }).
      then(response => {
        return response.json();
      }).then(response => {
        this.recipes = response;
        console.log(this.recipes)
      })
      this.showList = true;
    },
    soup() {
      this.$http.get('http://localhost:8080/nevimei/webapi/soups',{
          headers: {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          }
        }).
      then(response => {
        return response.json();
      }).then(response => {
        this.recipes = response;
        console.log(this.recipes)
      })
      this.showList = true;
    },
    meal() {
      this.$http.get('http://localhost:8080/nevimei/webapi/meals',{
          headers: {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          }
        }).
      then(response => {
        return response.json();
      }).then(response => {
        this.recipes = response;
        console.log(this.recipes)
      })
      this.showList = true;
    },
    dessert() {
      this.$http.get('http://localhost:8080/nevimei/webapi/desserts',{
          headers: {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          }
        }).
      then(response => {
        return response.json();
      }).then(response => {
        this.recipes = response;
        console.log(this.recipes)
      })
      this.showList = true;
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
