var prefix = ctx + "system/article"

$(function() {
	var columns = [{
            checkbox: true
        },
		{
			field : 'articleId', 
			title : '文章id' 
		},
		{
			field : 'categoryId', 
			title : '文章种类id' 
		},
		{
			field : 'title', 
			title : '标题' 
		},
		{
			field : 'content', 
			title : '内容' 
		},
		{
			field : 'keyWords', 
			title : '关键字' 
		},
		{
			field : 'author', 
			title : '作者' 
		},
		{
			field : 'publishTime', 
			title : '发布时间' 
		},
		{
			field : 'publisher', 
			title : '发布人/机构' 
		},
		{
			field : 'recommend', 
			title : '是否推荐  1 推荐 2 不推荐' 
		},
		{
			field : 'isPublished', 
			title : '是否发布 1 发布 0 未发布' 
		},
		{
			field : 'state', 
			title : '状态，1 开启 2 关闭' 
		},
		{
			field : 'isTop', 
			title : '是否置顶 1 置顶 0 不置顶' 
		},
		{
			field : 'image', 
			title : '文章主图' 
		},
		{
			field : 'createTime', 
			title : '创建时间' 
		},
		{
			field : 'updateTime', 
			title : '更新时间' 
		},
		{
			field : 'delState', 
			title : '状态 1 已删除 2 未删除' 
		},
		{
			field : 'adminId', 
			title : '管理员id' 
		},
        {
            title: '操作',
            align: 'center',
            formatter: function(value, row, index) {
            	var actions = [];
				actions.push('<a class="btn btn-primary btn-sm ' + editFlag + '" href="#" title="编辑" mce_href="#" onclick="edit(\'' + row.articleId + '\')"><i class="fa fa-edit"></i></a> ');
				actions.push('<a class="btn btn-warning btn-sm ' + removeFlag + '" href="#" title="删除" onclick="remove(\'' + row.articleId + '\')"><i class="fa fa-remove"></i></a>');
				return actions.join('');
            }
        }];
	var url = prefix + "/list";
	$.initTable(columns, url);
});

/*文章-新增*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增文章", url);
}

/*文章-修改*/
function edit(articleId) {
    var url = prefix + '/edit/' + articleId;
    layer_showAuto("修改文章", url);
}

// 单条删除
function remove(id) {
	$.modalConfirm("确定要删除选中文章吗？", function() {
		_ajax(prefix + "/remove/" + id, "", "post");
    })
}

// 批量删除
function batchRemove() {
	var rows = $.getSelections("articleId");
	if (rows.length == 0) {
		$.modalMsg("请选择要删除的数据", "warning");
		return;
	}
	$.modalConfirm("确认要删除选中的" + rows.length + "条数据吗?", function() {
		_ajax(prefix + '/batchRemove', { "ids": rows }, "post");
	});
}
