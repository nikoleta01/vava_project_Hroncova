<template>
    <div style="max-width: 1000px; margin: auto">
      <div v-for="(recipe, index) in recipes" :key=index style="padding: 20px" align="left">
        <img style="cursor: pointer" v-on:click="selected(index)" height="100" width="150" :src="recipe.img" alt="Krtkova torta"> {{ recipe.name }}
      </div>
    </div>
</template>

<script>
export default {
    props: {
        recipes: Array
    },
    methods: {
        selected(index) {
            this.$emit("itemSelected", index)
        }
    }
}
</script>