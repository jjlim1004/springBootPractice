const axios = require("axios"); 
const cheerio = require("cheerio");
const request = require("request");
const client = require('cheerio-httpcli');
const log = console.log;
//request 모듈 사용하기
//https://medium.com/harrythegreat/node-js%EC%97%90%EC%84%9C-request-js-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-28744c52f68d


//얘는 잘 안됨
/*
const getHtml = async () => {
    try{
        return await axios.get("https://finance.naver.com/news/");
    }catch(error){
        console.log(error);
    }
};

getHtml().then(html =>{
    let ulList = [];
    const $ = cheerio.load(html.data);
    const $bodyList = $("div.main_news ul").children("li ");

    $bodyList.replaceWith(function(i,element){
        ulList[i] = {
            title: $(this).find("li").text(),
            href: $(this).find("li").attr("href")
        };
    });

    const data = ulList.filter(n=>n.title);
    return data;
}).then(res=>log(res));
*/
//출처: https://ppomelo.tistory.com/130 [ppomelo 🍐]


//얘는 잘 된다.
/* 
scrapingResult = {
    'date': '',
    'the_basic_rate': '',
    'buy': '',
    'sell': ''
}
 
function getData() {
    request("https://finance.naver.com/marketindex/exchangeDailyQuote.nhn", function (err, res, body) {
        const $ = cheerio.load(body);
        const bodyList = $(".tbl_exchange tbody tr").map(function (i, element) {
            scrapingResult['date'] = String($(element).find('td:nth-of-type(1)').text());
            scrapingResult['the_basic_rate'] =  String($(element).find('td:nth-of-type(2)').text());
            scrapingResult['buy'] =  String($(element).find('td:nth-of-type(4)').text());
            scrapingResult['sell'] =  String($(element).find('td:nth-of-type(5)').text());
 
            console.log(scrapingResult)
        });
    });
}
getData();
*/
//출처: https://data-make.tistory.com/436 [Data Makes Our Future]

//출처: https://hanswsw.tistory.com/6 [기록]  --안됨


// const { doesNotThrow } = require('assert');
// var url = "https://finance.naver.com/main/main.nhn";

// request(url, (error, response, body) => {

//     let list =[];
//     let $ = cheerio.load(body);
//     let $li =  $('div.section_strategy ul').children('li');
  
//     $li.each(function(i,e){
//         list[i] = {
//             title: $(this).find('span a').text()
//         };
//         console.log(list[i].title);
//     });
// });
// 출처 https://kimcoder.tistory.com/161

/*
const getHtml = async () => {
    try {
      return await axios.get("https://www.yna.co.kr/sports/all");
    } catch (error) {
      console.error(error);
    }
  };
  
  getHtml()
    .then(html => {
      let ulList = [];
      const $ = cheerio.load(html.data);
      const $bodyList = $("div.headline-list ul").children("li.section02");
  
      $bodyList.each(function(i, elem) {
        ulList[i] = {
            title: $(this).find('strong.news-tl a').text(),
            url: $(this).find('strong.news-tl a').attr('href'),
            image_url: $(this).find('p.poto a img').attr('src'),
            image_alt: $(this).find('p.poto a img').attr('alt'),
            summary: $(this).find('p.lead').text().slice(0, -11),
            date: $(this).find('span.p-time').text()
        };
      });
  
      const data = ulList.filter(n => n.title);
      return data;
    })
    .then(res => log(res));
    */
    //출처 https://velog.io/@yesdoing/Node.js-%EC%97%90%EC%84%9C-%EC%9B%B9-%ED%81%AC%EB%A1%A4%EB%A7%81%ED%95%98%EA%B8%B0-wtjugync1m --안됨