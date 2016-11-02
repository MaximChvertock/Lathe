<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>


<!-- JavaScripts placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/shop/assets/js/jquery-1.10.2.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/jquery-migrate-1.2.1.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/gmap3.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/bootstrap-hover-dropdown.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/css_browser_selector.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/echo.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/jquery.easing-1.3.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/bootstrap-slider.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/jquery.raty.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/jquery.prettyPhoto.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/jquery.customSelect.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/wow.min.js"/>"></script>
<script src="<c:url value="/resources/shop/assets/js/scripts.js"/>"></script>

<!-- For demo purposes – can be removed on production -->

<script src="<c:url value="/resources/shop/switchstylesheet/switchstylesheet.js"/>"></script>

<script>
    $(document).ready(function () {
        $(".changecolor").switchstylesheet({seperator: "color"});
        $('.show-theme-options').click(function () {
            $(this).parent().toggleClass('open');
            return false;
        });
    });

    $(window).bind("load", function () {
        $('.show-theme-options').delay(2000).trigger('click');
    });
</script>
<!-- For demo purposes – can be removed on production : End -->

<script src="<c:url value="http://w.sharethis.com/button/buttons.js"/>"></script>

