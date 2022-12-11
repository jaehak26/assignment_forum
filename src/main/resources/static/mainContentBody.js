import {fetchData} from "./fetchData.js"

var myHeaders = new Headers();
myHeaders.append("Cookie", "JSESSIONID=DA9FBFFDA1EA67C3BEED433BAD9ABCEA");

var requestOptions = {
    method: 'GET',
    headers: myHeaders,
    redirect: 'follow'
};

const PAGE = 0;
const SIZE = 2;
let mainContentPageUrl = `http://localhost:8080/mainContent/page?page=${PAGE}&size=${SIZE}`;

const mainContentPageData = await fetchData(mainContentPageUrl, requestOptions);

console.log(mainContentPageData)
//table 내용
let mainContentBody = document.querySelector("#mainContentTable");
let mainContent = "<table><thead><tr><td>글 번호</td>"+
                    "<td>글 제목</td>" +
                    "<td>아이디</td></tr></thead><tbody>"
console.log(document)
// 글 번호,, 글 제목, 아이디 순
for(let idx=0; idx<SIZE; idx++){
    let innerContent = mainContentPageData.content[idx]
    mainContent += `<tr></tr><td>${innerContent.contentId}</td>`
        +`<td><a href="">${innerContent.title}</a></td>`
        +`<td>${innerContent.userId}</td></tr>`

}

mainContent += "</tbody></table>"
console.log(mainContent)
mainContentBody.innerHTML = mainContent;