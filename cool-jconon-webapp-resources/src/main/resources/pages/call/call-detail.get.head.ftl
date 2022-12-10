<meta property="og:type" content= "website" />
<meta property="og:url" content="${contextURL}"/>
<meta property="og:site_name" content="${message("main.title")}" />
<meta name="msapplication-TileImage" content="${contextURL}/res/img/apple-touch-icon-114x114.png" />
<meta name="twitter:card" content="summary"/>
<meta name="twitter:domain" content="${contextURL}"/>
<meta name="twitter:title" property="og:title" itemprop="name" content="${message(call['cmis:objectTypeId'])} - ${call['jconon_call:codice']}" />
<meta name="twitter:description" property="og:description" itemprop="${call['jconon_call:descrizione']}" />
<script src="${url.context}/res/js/thirdparty/require.js" data-main="ws/call/call-detail.js"></script>
<link href="${url.context}/res/css/select2.css" rel="stylesheet">