
let index = {
    init: function () {
        $("#btn_save").on("click", () => {
            this.save();
        });
        $("#btn_update").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.updateWiki();
        });
    },



    save: function () {
        let data={
            title: document.getElementById('title').value,
            content: document.getElementById('content').value,
        };

        $.ajax({
            type: "POST",
            url: "/api/manager/wiki",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("wiki 쓰기 완료");
            location.href="/"
        }).fail(function (error){
            alert("wiki 쓰기 실패"+JSON.stringify(error));
        });
    },

    updateWiki : function (){
        let id=document.getElementById('id').value;

        let data={
            title: document.getElementById('title').value,
            content: document.getElementById('content').value,
        };

        $.ajax({
            type: "PUT",
            url: "/api/manager/wiki/"+id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("wiki 수정 완료");
            location.href="/"
        }).fail(function (error){
            alert("wiki 수정 실패"+JSON.stringify(error));
        });
    },
}

index.init();