
let index = {
    init: function () {
        $("#btn_save").on("click", () => {
            this.save();
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
}

index.init();