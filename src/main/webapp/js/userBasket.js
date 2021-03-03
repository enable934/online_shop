$( document ).ready(function() {
    userBasketData(generateTable);
});

let generateTable = (data) => {
    $('#basket-table-body').empty();
    data.items.sort((a, b) => a.itemId - b.itemId);
    data.items.forEach(i => {
        var item = createRow(i.itemId, i.itemName, i.itemsCount, i.totalPrice);
        $('#basket-table-body').append(item);
    });

    $('#basket-total-price').text((Math.round(data.totalPrice * 100) / 100) + '$');
}

let createRow = (itemId, itemName, count, totalPrice) => {
    var row = document.createElement('tr');
    row.id = itemId;

    var nameCell = document.createElement('td');
    nameCell.className = "td-name";
    nameCell.innerText = itemName;

    var countCell = createCountTd(itemId, count);

    var totalPriceCell = document.createElement('td');
    totalPriceCell.className = "td-total-price";
    totalPriceCell.innerText = (Math.round(totalPrice * 100) / 100) + '$';

    row.appendChild(nameCell);
    row.appendChild(countCell);
    row.appendChild(totalPriceCell);

    return row;
}

let createCountTd = (itemId, count) => {
    var countCell = document.createElement('td');
    countCell.className = "td-count";

    var minusButton = document.createElement('button');
    minusButton.className = "btn-count";
    minusButton.value = itemId;
    minusButton.onclick = subtractItem;
    minusButton.innerText = "-";

    var plusButton = document.createElement('button');
    plusButton.className = "btn-count";
    plusButton.value = itemId;
    plusButton.onclick = addItem;
    plusButton.innerText = "+";

    var countSpan =  document.createElement('span');
    countSpan.className = "span-count";
    countSpan.innerText = count;

    countCell.appendChild(minusButton);
    countCell.appendChild(countSpan);
    countCell.appendChild(plusButton);

    return countCell;
}

let addItem = (e) => {
    addOrSubtractItemInBasket(e.target.value, true,
    () => {
            userBasketData(generateTable);
            userBasketData(setBasketItemsCount);
        });
}

let subtractItem = (e) => {
    addOrSubtractItemInBasket(e.target.value, false,
        () => {
            userBasketData(generateTable);
            userBasketData(setBasketItemsCount);
        });
}

let confirmOrder = () => {
    $.ajax({
        url: 'userBasketDataServlet',
        type: 'POST',
        data: {},
        success: function(result) {
            userBasketData(generateTable);
            userBasketData(setBasketItemsCount);
        },
        error: function(request,msg,error) {
            alert(error);
        }
    });

}

