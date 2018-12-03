let booksByAuthor;
let booksByTitle;

function getAndDisplayBooks(){
	const query = document.getElementById('query').value;
	const url = 'http://localhost:8080/search?q=' + query;
	const ul = document.getElementById('bookList');

	clearElement(ul);

	fetch(url)
		.then(response => {
			if(!response.ok){
				throw Error(response.statusText);
			}
			return response.json();
		}).then(function(books){
			books.sort(compareBookAuthors);
			booksByAuthor = books;

			booksByTitle = books.slice().sort(compareBookTitles);
		
			displayBooks(booksByTitle, ul);
		}).catch(error => {
			console.error('Error:', error)
			const errorSpan = document.getElementById('errorSpan');
			errorSpan.innerHTML = "Please retry.";
		});

}

function createNode(element) {
	return document.createElement(element);
}

function append(parent, element) {
	return parent.appendChild(element);
}

 function clearElement(element){
	element.innerHTML = '';
 }

 function compareBookAuthors(a, b){
	if(a.author > b.author){
		return 1;
	} else if(a.author < b.author){
		return -1;
	} else{
		return 0;
	}
 }

function compareBookTitles(a, b){
	if(a.title > b.title){
		return 1;
	} else if(a.title < b.title){
		return -1;
	} else{
		return 0;
	}
 }

function displayBooks(books, ul){
	if(typeof books === "undefined"){
		return;
	}

	clearElement(ul);
	return books.map(function(book){
				const li = createNode('li');
				const img = createNode('img');
				const titleSpan = createNode('span');
				const authorSpan = createNode('span');

				img.src = book.imgUrl;
				titleSpan.innerHTML = book.title;
				authorSpan.innerHTML = book.author;

				append(li, img);
				append(li, titleSpan);
				append(li, authorSpan);
				append(ul, li);
			})
}

function displayBooksByAuthor(){
displayBooks(booksByAuthor, document.getElementById('bookList'));
}

function displayBooksByTitle(){
displayBooks(booksByTitle, document.getElementById('bookList'));
}