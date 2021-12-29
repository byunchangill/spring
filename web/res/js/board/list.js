function moveToDetail(iboard) {
    location.href='/board/detail?iboard=' + iboard;
}
var trList = document.querySelectorAll('.record');

for (var i = 0; i < trList.length; i++) {
    // const tr = trList[i];
    // setEvent(tr);
    setEvent(trList[i]);
}

// 클로저 (closure)
function setEvent(tr) {
    tr.addEventListener('click', function () {
        moveToDetail(tr.dataset.iboard);
    });
}