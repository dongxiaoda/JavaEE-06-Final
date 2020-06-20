document.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>");

function refreshTable_func() {

    const url = "http://localhost:8080/proxy/student-service/Student/findAll";

    axios({
        method: 'get',
        url: url,
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            let homeworkData = [];
            for (let i = 0; i < response.data.data.length; i++) {
                homeworkData.push(response.data.data[i]);
            }

            // 获取表格对象
            let table = document.getElementById("studentTable");

            // 获取表格行数
            let row = table.rows.length;

            // 循环插入
            for (let i = 0; i < homeworkData.length; i++) {

                // 新建一行
                let tableRow = table.insertRow(i + row);

                let tableCellArray = [];

                for (let j = 0; j < 5; j++) {
                    tableCellArray[j] = tableRow.insertCell(j);
                }

                tableCellArray[0].innerHTML = homeworkData[i].id;
                tableCellArray[1].innerHTML = homeworkData[i].name;
                tableCellArray[2].innerHTML = homeworkData[i].password;
                tableCellArray[3].innerHTML = homeworkData[i].createTime;
                tableCellArray[4].innerHTML = homeworkData[i].updateTime;

                tableRow.align = 'center';

                table.appendChild(tableRow);
            }
        })
        .catch(function (error) {
            alert("Fail to get homework");
        });
}

function updateStudent_func() {

    const id = document.getElementById("studentId_2").value;
    const name = document.getElementById("studentName_2").value;
    const password = document.getElementById("password_2").value;

    const url = "http://localhost:8080/proxy/student-service/Student/register";

    axios({
        method: 'post',
        url: url,
        data: {
            "id": id,
            "name": name,
            "password": password
        },
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            alert("Succeed to update student");
        })
        .catch(function (error) {
            alert("Fail to update student");
        });

    location.reload();

}

function addStudent_func() {

    const name = document.getElementById("studentName_1").value;
    const password = document.getElementById("password_1").value;

    const url = "http://localhost:8080/proxy/student-service/Student/register";

    axios({
        method: 'post',
        url: url,
        data: {
            // "id": id,
            "name": name,
            "password": password
        },
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            alert("Succeed to add student");
        })
        .catch(function (error) {
            alert("Fail to add student");
        });

    location.reload();
}