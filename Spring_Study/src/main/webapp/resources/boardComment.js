console.log("boardComment.Js 진입");
console.log(">>> bnoVal >>> " + bnoVal);

document.getElementById('cmtAddBtn').addEventListener('click', ()=>{
  const cmtText = document.getElementById('cmtText').value;
  const cmtWriter = document.getElementById('cmtWriter').value;
  if(cmtText == "" || cmtText == null){
    alert("댓글을 입력해주세요!");
    document.getElementById('cmtText').focus();
    return false;
  } else {
    let cmtData = {
      bno: bnoVal,
      writer: cmtWriter,
      content: cmtText
    };
    console.log(cmtData);

    // 댓글 등록시 비동기 통신 호출
    postCommentToServer(cmtData).then(result => {
      console.log(result);
      if(result == "1"){
        alert("댓글등록 성공 ~ !!");
        // 화면에 뿌리기
        getCommentList(bnoVal);
      }
    })
  }
});

async function postCommentToServer(cmtData){
  try {
    const url = "/comment/post";
    const config = {
      method: 'post',
      headers: {
        'content-type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify(cmtData)
    }
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  } catch (error) {
    console.log(error);
  }
}

function getCommentList(bnoVal){
  
}