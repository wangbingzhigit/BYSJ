# 关于页码
1.页码溢出问题</br>
当我们的数据库中的总条数`（totalCount）`和每页显示数`（pageSize）`不能够整除的时候，我们可能会遇到页码溢出的问题,如我们当前的总页数只有5页的情况下，
可能会多出现第六页第第七页的情况，但是在第六页第七页根本就没有数据可以显示了，这个时候就需要在jsp页面上做出判断，针对当前页的前一页和当前页的后一页进行
赋值，具体情况如图所示</br>
![image](https://github.com/wangbingzhigit/BYSJ/src/main/resources/pic1.png)
![image](http://github.com/itmyhome2013/readme_add_pic/raw/master/images/nongshalie.jpg)