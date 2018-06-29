$("#form-article-add").validate({
	rules:{
		xxxx:{
			required:true,
		},
	},
	submitHandler:function(form){
		add();
	}
});

function add() {
    _ajax_save(ctx + "system/article/save", $('#form-article-add').serialize());
}