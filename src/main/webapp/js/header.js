let userBasketData = (callback) => {
    var prefix = document.location.href.includes("/user/") ? "" : "user/" ;
    $.get(prefix + "userBasketDataServlet", {}, function(userBasketData) {
        callback(userBasketData);
    });
};

let addOrSubtractItemInBasket = (itemId, isAdd, successCallback) => {
    var prefix = document.location.href.includes("/user/") ? "" : "user/" ;

    $.ajax({
        url: prefix + 'userBasketDataServlet',
        type: 'PUT',
        data: {itemId: itemId, isAdd: isAdd},
        success: function(result) {
            successCallback();
        },
        error: function(request,msg,error) {
            alert(error);
        }
    });
}

let setBasketItemsCount = (data) => {
    if(data.totalCount !== undefined)
        $('#basket-items-count').text(data.totalCount);
}

$( document ).ready(function() {
    userBasketData(setBasketItemsCount);

    $('.btn-buy').click(function() {
        addOrSubtractItemInBasket(this.id, true, () => userBasketData(setBasketItemsCount));
    })
});

