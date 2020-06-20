document.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>");

function refreshTable_func() {

    const url = "http://localhost:8080/proxy/student-homework-service/StudentHomework/findAll";

    axios({
        method: 'get',
        url: url,
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            let stuHomeworkData = [];
            for (let i = 0; i < response.data.data.length; i++) {
                stuHomeworkData.push(response.data.data[i]);
            }

            // 获取表格对象
            let table = document.getElementById("stuHomeworkTable");

            // 获取表格行数
            let row = table.rows.length;

            // 循环插入
            for (let i = 0; i < stuHomeworkData.length; i++) {


                // 新建一行
                let tableRow = table.insertRow(i + row);

                let tableCellArray = [];

                for (let j = 0; j < 6; j++) {
                    tableCellArray[j] = tableRow.insertCell(j);
                }

                tableCellArray[0].innerHTML = stuHomeworkData[i].id;
                tableCellArray[1].innerHTML = stuHomeworkData[i].studentId;
                tableCellArray[2].innerHTML = stuHomeworkData[i].homeworkId;
                tableCellArray[3].innerHTML = stuHomeworkData[i].homeworkContent;
                tableCellArray[4].innerHTML = stuHomeworkData[i].homeworkTitle;
                tableCellArray[5].innerHTML = stuHomeworkData[i].createTime;

                tableRow.align = 'center';

                table.appendChild(tableRow);
            }
        })
        .catch(function (error) {
            alert("Fail to get student homework");
        });

}

