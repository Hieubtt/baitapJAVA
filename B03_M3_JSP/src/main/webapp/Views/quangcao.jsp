<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Product Display Area -->
<div class="product-display">
    <button class="nav-btn prev">❮</button>
    <div class="product-wrapper">
        <c:forEach items="${dsqc}" var="s" varStatus="loop">
            <div class="product-item" style="display: ${loop.index == 0 ? 'block' : 'none'};">
                <img src="${pageContext.request.contextPath}/img/${s.hinhAnh}" alt="${s.tenSua}">
                <p class="product-name">${s.tenSua}</p>
            </div>
        </c:forEach>
    </div>
    <button class="nav-btn next">❯</button>
</div>

<!-- Product Display CSS -->
<style>
.product-display {
    position: relative;
    max-width: 300px;
    margin: 20px auto;
    display: flex;
    align-items: center;
    justify-content: center;
}

.product-wrapper {
    text-align: center;
}

.product-item {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 8px;
}

.product-item img {
    width: 100%;
    height: auto;
    border-radius: 8px;
}

.product-name {
    margin: 10px 0 0;
    font-size: 1rem;
    color: #333;
}

.nav-btn {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    font-size: 1.5rem;
    background: rgba(0,0,0,0.5);
    color: white;
    border: none;
    cursor: pointer;
    z-index: 10;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.nav-btn.prev {
    left: 0;
}

.nav-btn.next {
    right: 0;
}
</style>

<!-- Product Display Script -->
<script>
document.addEventListener("DOMContentLoaded", function() {
    const products = document.querySelectorAll(".product-item");
    const nextBtn = document.querySelector(".nav-btn.next");
    const prevBtn = document.querySelector(".nav-btn.prev");

    if (!products || products.length === 0) {
        console.log("Error: No products found. Check if ${dsqc} has data.");
        return;
    }

    let currentIndex = 0;

    function showProduct(index) {
        products.forEach((product, i) => {
            product.style.display = i === index ? "block" : "none";
        });
    }

    nextBtn.addEventListener("click", function() {
        if (currentIndex < products.length - 1) {
            currentIndex++;
            showProduct(currentIndex);
        }
    });

    prevBtn.addEventListener("click", function() {
        if (currentIndex > 0) {
            currentIndex--;
            showProduct(currentIndex);
        }
    });

    showProduct(currentIndex); // Hiển thị sản phẩm đầu tiên
});
</script>