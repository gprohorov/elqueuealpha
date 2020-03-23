<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Total Work Day</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <a href="/" type="button" class="btn btn-info">Home</a>
        <form name="TotalWorkDay" action="" method="GET">
            <table class="table table-sm table-striped table-bordered table-dark">
                <tr class="bg-success">
                    <th>Место</th>
                    <th>Дата</th>
                    <th>Процедуры</th>
                    <th>Общая</th>
                </tr>
                <#list totals as total>
                <tr>
                    <td>Черновцы</td>
                    <td>${total.date}</td>
                    <td>${total.procedureCV}</td>
                    <td>${total.totalCV}</td>
                </tr>
                <tr>
                    <td>Клишковцы</td>
                    <td>${total.date}</td>
                    <td>${total.procedureKL}</td>
                    <td>${total.totalKL}</td>
                </tr>
                <tr>
                    <td>Мигово</td>
                    <td>${total.date}</td>
                    <td>${total.procedureMG}</td>
                    <td>${total.totalMG}</td>
                </tr>
                </#list>
            </table>
        </form>
    </div>
</body>
</html>
