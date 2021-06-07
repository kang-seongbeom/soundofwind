let index = {
    init: function () {
        $("#btn_save").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.save();
        });

        $("#btn_update").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.update();
        });

    },
    save: function () {
        let data = {
            username: document.getElementById('username').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value
        };
        $.ajax({
            type: "POST",
            url: "/auth/joinApi",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            if (resp.status == 500) {
                alert("회원가입 실패");
            } else {
                alert("회원가입 완료");
                location.href = "/"
            }

        }).fail(function (error) {
            alert("회원가입 실패" + JSON.stringify(error));
        });
    },

    update: function () {
        let data = {
            id: document.getElementById('id').value,
            userName: document.getElementById('username').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value
        };
        $.ajax({
            type: "PUT",
            url: "/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("회원수정 완료");
            location.href = "/"
        }).fail(function (error) {
            alert("회원수정 실패" + JSON.stringify(error));
        });
    }
}

index.init();