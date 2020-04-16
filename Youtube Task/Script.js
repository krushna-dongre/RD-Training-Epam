const youTuberSearchHelper = (function() {
  var datas;
  var searchData;
  var apiKey;
  var maxResult;
  var url;
  fetchData = function() {
    searchData = document.getElementById("search-data").value
      ? document.getElementById("search-data").value
      : "";
    apiKey = "AIzaSyANK-Op4StCjy106aleazu2WhdqUD6gRh8";
    maxResult = 21;
    url = `https://www.googleapis.com/youtube/v3/search?key=${apiKey}&type=video&part=snippet&maxResults=${maxResult}&q=${searchData}`;
    if (document.getElementById("search-data")) {
      conditionalFetching(url);
    }
  };
  function displayData(data) {
    var mainNode = document.getElementById("main");
    mainNode.innerHTML = "";
    data.items.forEach(element => {
      var thumb = element.snippet.thumbnails.medium.url;
      var title = element.snippet.title;
      var desc = element.snippet.description.substring(0, 100);
      var vid = element.id.videoId;
      var videoLink = `https://www.youtube.com/watch?v=${vid}`;
      var publishDate = element.snippet.publishedAt.substring(0, 10);
      var channelName = element.snippet.channelTitle;

      mainNode.innerHTML += ` <article class="item">
                                    <a href="${videoLink}"  target="_blank"> 
                                       <img src="${thumb}" alt="video icon" class="thumb">
                                    </a>
                                    <div class="details">
                                        <h4><a href="${videoLink}" target="_blank">${title}</a></h4>
                                        <p>Published on ${publishDate} by ${channelName}<p>
                                        <p>${desc}</p>
                                    </div>
                                </article>
                            `;
    });
  }
  function next() {
    conditionalFetching(
      `https://www.googleapis.com/youtube/v3/search?key=${apiKey}&type=video&part=snippet&maxResults=${maxResult}&pageToken=${datas.nextPageToken}&q=${searchData}`
    );
  }
  function previous() {
    if (typeof datas.prevPageToken !== "undefined") {
      conditionalFetching(
        `https://www.googleapis.com/youtube/v3/search?key=${apiKey}&type=video&part=snippet&maxResults=${maxResult}&pageToken=${datas.prevPageToken}&q=${searchData}`
      );
    }
  }

  function conditionalFetching(url) {
    fetch(url)
      .then(response => {
        return response.json();
      })
      .then(data => {
        datas = data;
        displayData(data);
      });
  }

  triggerSearchButton = function() {
    document
      .querySelector("#search-data")
      .addEventListener("keypress", function(e) {
        if (e.key === "Enter") {
          document.getElementById("search-btn").click();
        }
      });
  };
  return {
    fetchData: fetchData,
    next: next,
    previous: previous,
    triggerSearchButton: triggerSearchButton
  };
})();
youTuberSearchHelper.fetchData();
youTuberSearchHelper.triggerSearchButton();
