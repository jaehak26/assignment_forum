


export const fetchData = async (url, requestOptions) => {
    const response = await fetch(url, requestOptions);
    const result = await response.json();
    return result;
}

