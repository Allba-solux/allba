<template lang="">
    <div>
    <div class="card">
    <div class="card-body">
        <h5 class="card-title" >{{ name }}</h5>
        <p class="card-text" >{{ description }}</p>
          <a href="#" class="btn btn-light">참가요청</a>
    </div>
    </div>        
    </div>
</template>
<script>
defineProps({
	name: {
		type: String,
	},
	description: {
		type: String,
	},
});
</script>

<style lang="">
    
</style>