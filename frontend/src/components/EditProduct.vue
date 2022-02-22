<template>
  <div v-if="currentProduct">
    <div class="mb-3">
      <label for="productName" class="form-label">Product Name</label>
      <input type="text" class="form-control" id="productName" required name="productName" v-model="currentProduct.productName">
    </div>
    <div class="mb-3">
      <label for="category" class="form-label">Category</label>
      <input type="text" class="form-control" id="category" required name="category" v-model="currentProduct.category">
    </div>
    <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="text" class="form-control" id="price" required name="price" v-model="currentProduct.price">
    </div>
    <div class="mb-3">
      <button @click="updateProduct" class="btn btn-primary me-3">Update</button>
      <button @click="deleteProduct" class="btn btn-danger">Dlete</button>
    </div>
    <div class="alert alert-success" role="alert" v-if="message">
      {{message}}
    </div>
  </div>
</template>

<script>
import ProductDataService from "@/services/ProductDataService";

export default {
  name: "edit-product",
  data() {
    return {
      currentProduct: null,
      message: ''
    }
  },
  methods: {
    getProduct(id) {
      ProductDataService.get(id)
      .then(res => {
        this.currentProduct = res.data
      })
      .catch(e => {
        console.log(e)
      })
    },
    updateProduct(){
      ProductDataService.update(this.currentProduct.id, this.currentProduct)
      .then(() => {
        this.message = 'The product was successfully updated.'
      })
      .catch(e => {
        console.log(e)
      })
    },
    deleteProduct(){
      ProductDataService.delete(this.currentProduct.id)
      .then(() => {
        this.$router.push({name: 'products'})
      })
      .catch(e => {
        console.log(e)
      })
    }
  },
  mounted() {
    this.getProduct(this.$route.params.id)
  }
}
</script>

<style scoped>

</style>