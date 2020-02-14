export let EditBookData = (id, title, authorName, genreName) => {
    return (
        {
            id: id,
            title: title,
            author:
                {
                    name: authorName
                }
            ,
            genre:
                {
                    name: genreName
                }
        }
    );
};
