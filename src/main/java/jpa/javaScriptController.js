/**
 * Created by nikorobidoux on 2/16/2017.
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/createAddressBook"
    }).then(function(data) {
        $('.addressBook-id').append(adddressBook.id);
    });
});
