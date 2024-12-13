function buildUrl(url, options) {
  let builtUrl;

  if (url === null) {
    builtUrl = "";
  } else if (typeof url === "object") {
    builtUrl = "";
    options = url;
  } else {
    builtUrl = url;
  }
  if (options) option(builtUrl, options);

  return builtUrl;
}

function option(builtUrl, options) {
  if (options.path) {
    builtUrl += "/" + options.path;
  }

  let queryString = [];
  let key;

  if (options.queryParams) {
    for (key in options.queryParams) {
      if (options.queryParams.hasOwnProperty(key)) {
        queryString.push(key + "=" + options.queryParams[key]);
      }
    }
    builtUrl += "?" + queryString.join("&");
  }

  if (options.hash) {
    builtUrl += "#" + options.hash;
  }
}
