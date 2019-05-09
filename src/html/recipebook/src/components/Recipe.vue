<template>
    <div style="max-width: 1000px; margin: auto">
        <div style="padding: 20px" align="left">
            <h3>{{ recipe.name }}</h3>
        <img height="200" width="300" :src="recipe.img" alt="Krtkova torta">
        <br>
        <p>{{recipe.description}}</p>
        <h5>{{ $t('recipe.servings')}}: {{recipe.servings}}</h5>
        <h5>{{ $t('recipe.prepTime') }}: {{recipe.prepTime}} min</h5>
        <hr>
        <h4>{{ $t('recipe.ingredients') }}</h4>
        <ul>
            <li v-for="(ing, i) in recipe.ingredients" :key=i>{{ ing }}</li>
        </ul>
        <hr>
        <h4>{{ $t('recipe.directions') }}</h4>
        <ul>
          <li v-for="(ord, i) in recipe.directions" :key="i">{{ ord }}</li>
        </ul>
      </div>
    </div>
</template>

<script>
export default {
    props: {
        recipe: Object
    }
}
</script>