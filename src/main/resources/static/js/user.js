
let $btn_save = document.getElementById("btn_save");

$btn_save.addEventListener("click",()=>{
    let data={
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        email: document.getElementById('email').value
    };
    //ajax을 통해 위 3개의 파라미터를 json으로 변환 한 뒤, insert요청
    $.ajax({
        type: "POST",
        url: "/auth/joinApi",
        data: JSON.stringify(data), //http body데이터
        contentType: "application/json; charset=utf-8", //body data가 이떤 타입인지(MIME)
        dataType: "json" //응답이 왔을 때 json javascript로 변환, ajax 통신이 성공하고 서버가json을 리턴하면 dataType이 json이 아니어도 자동으로 자바 오브젝트로 알아서 변환 해 주는거 같음(확실x).
    }).done(function(resp){ //파라미터 resp값은 자바 오브젝트임. json아님
        if(resp.status==500){
            alert("회원가입 실패");

        }else{
            alert("회원가입 완료");
            location.href="/"
        }

    }).fail(function (error){
        alert("회원가입 실패"+JSON.stringify(error));
    });
})