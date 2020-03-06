function confirmDelete () {
  let confirmation = confirm("Deleting your guild will erase all the data are you sure about that?");

  if (confirmation) {
    window.location = "Delete"
  }

}