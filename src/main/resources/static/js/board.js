
let index = {
    init: function () {
        $("#btn_save").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.save();
        });
        $("#btn_update").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.updateBoard();
        });
        $("#btn_delete").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.deleteBoard();
        });
        $("#btn_reply_save").on("click", () => { //this를 바인딩하기 위해서 function대신 화살표를 사용
            this.replySave();
        });

    },

    save: function () {
        let data={
            title: document.getElementById('title').value,
            content: document.getElementById('content').value,
        };

        //ajax을 통해 위 3개의 파라미터를 json으로 변환 한 뒤, insert요청
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data), //http body데이터
            contentType: "application/json; charset=utf-8", //body data가 이떤 타입인지(MIME)
            dataType: "json" //응답이 왔을 때 json javascript로 변환, ajax 통신이 성공하고 서버가json을 리턴하면 dataType이 json이 아니어도 자동으로 자바 오브젝트로 알아서 변환 해 주는거 같음(확실x).
        }).done(function(resp){ //파라미터 resp값은 자바 오브젝트임. json아님
            alert("글쓰기 완료");
            location.href="/"
        }).fail(function (error){
            alert("글쓰기 실패"+JSON.stringify(error));
        });
    },

    updateBoard : function (){
        let id=document.getElementById('id').value;

        let data={
            title: document.getElementById('title').value,
            content: document.getElementById('content').value,
        };

        $.ajax({
            type: "PUT",
            url: "/api/board/"+id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("글수정 완료");
            location.href="/"
        }).fail(function (error){
            alert("글수정 실패"+JSON.stringify(error));
        });
    },

    deleteBoard: function () {
        let id=document.getElementById('id').innerText;
        $.ajax({
            type: "DELETE",
            url: "/api/board/"+id,
            dataType: "json"
        }).done(function(resp){
            alert("게시글 삭제 완료");
            location.href="/"
        }).fail(function (error){
            alert("게시글 삭제 실패"+JSON.stringify(error));
        });
    },

    replySave: function () {
        let data={
            userId: document.getElementById('userId').value,
            boardId: document.getElementById('boardId').value,
            content: document.getElementById('reply_content').value
        };
        console.log(data)

        //ajax을 통해 위 3개의 파라미터를 json으로 변환 한 뒤, insert요청
        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("댓글작성 완료");
            location.href=`/board/${data.boardId}`;
        }).fail(function (error){
            alert("댓글작성 실패"+JSON.stringify(error));
        });
    },

    replyDelete: function (boardId,replyId) {
        $.ajax({
            type: "DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            dataType: "json"
        }).done(function(resp){ //파라미터 resp값은 자바 오브젝트임. json아님
            alert("댓글삭제 완료");
            location.href=`/board/${boardId}`;
        }).fail(function (error){
            alert("댓글삭제 실패"+JSON.stringify(error));
        });
    }
}

index.init();