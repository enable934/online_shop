let userBasketData = (callback) => {
    $.get("userBasketServlet", {}, function(userBasketData) {
        callback(userBasketData.totalCount);
    });
};

let addItemToBasket = (itemId) => {
    $.ajax({
        url: 'userBasketServlet',
        type: 'PUT',
        data: {itemId: itemId, isAdd: true},
        success: function(result) {
            userBasketData(setBasketItemsCount);
        },
        error: function(request,msg,error) {
            alert(error);
        }
    });
}

let setBasketItemsCount = (count) => {
    if(count)
        $('#basket-items-count').text(count);
}

$( document ).ready(function() {
    userBasketData(setBasketItemsCount);

    $('.btn-buy').click(function() {
        addItemToBasket(this.id);
    })
});

