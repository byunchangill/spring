var btnContainerELem = document.querySelector('#btnContainer');
var btnDelElem = btnContainerELem.querySelector('#btnDel');
btnDelElem.addEventListener('click', function () {
    if (confirm('댓글을 삭제하시겠습니까?')) {
        location.href = '/board/del?iboard=' + btnContainerELem.dataset.iboard;
    }
});