<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <h2>id : ${task.id} のタスク詳細ページ</h2>
    <form method="POST" action="${pageContext.request.contextPath}/update">
    </form>
        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>