<%@ include file="init.jsp"%>
<!doctype html>
<html>
<head>
    <title>Capture picture from your webcam</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webcamjs/1.0.25/webcam.js"></script>
</head>

<body>
    <portlet:actionURL var="UploadURL" name="uploadImage"/>
    <div id="camera" style="height:auto;width:auto; text-align:left;"></div>

    <!--FOR THE SNAPSHOT-->
    <input type="button" value="Take a Snap" id="btPic" onclick="takeSnapShot()" /> 
    <p id="snapShot"></p>
    <aui:form action="${UploadURL}" name="profileform" method="post">
	<aui:input name="picture" type="hidden"></aui:input>
	<aui:button type="submit" name="btnUploadFile" value="Upload"></aui:button>
</aui:form>
</body>

<script>
    // CAMERA SETTINGS.
    Webcam.set({
        width: 220,
        height: 190,
        image_format: 'jpeg',
        jpeg_quality: 100
    });
    Webcam.attach('#camera');

    // SHOW THE SNAPSHOT.
    takeSnapShot = function () {
        Webcam.snap(function (data_uri) {
            document.getElementById('snapShot').innerHTML = 
                '<img src="' + data_uri + '" width="70px" height="50px" />';
            document.getElementById("<portlet:namespace />picture").value = data_uri;

        });
    }
</script>
</html>
