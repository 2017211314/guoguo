$("#form-article-edit").validate({
	rules:{
		xxxx:{
			required:true,
		},
	},
	submitHandler:function(form){
		update();
	}
});

function update() {
    _ajax_save(ctx + "system/article/save", $('#form-article-edit').serialize());
}