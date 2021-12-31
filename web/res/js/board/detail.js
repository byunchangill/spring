var btnContainerELem = document.querySelector('#btnContainer');
var btnDelElem = btnContainerELem.querySelector('#btnDel');
btnDelElem.addEventListener('click', function () {
    if (confirm('삭제하시겠습니까?')) {
        location.href = '/board/del?iboard=' + btnContainerELem.dataset.iboard;
    }
});

var btnUpdateElem = btnContainerELem.querySelector('#btnUpdate');
btnUpdateElem.addEventListener('click', function () {
    location.href = '/board/update?iboard=' + btnContainerELem.dataset.iboard;
});