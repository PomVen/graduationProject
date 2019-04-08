function openNewWin(uri){
    window.open (
        uri,
        "_self", //新窗口的打开方式：_self：不打开新的窗口，而是在当前页面刷新；newwindow：新打开一个窗口
        "height=100, width=400, top=0, left=0, " +
        "toolbar=no, " +//是否显示工具栏
        "menubar=no, " + //是否显示菜单栏
        "scrollbars=no, " + //是否显示滚动条
        "resizable=no," +  //窗口大小是否可调
        "location=no, " + //是否显示搜索栏
        "status=no"//是否显示状态栏
    );
}