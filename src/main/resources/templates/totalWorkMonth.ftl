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
    <div class="container-fluid">
        <div class="container" style="display: flex; flex-direction: row">
            <a href="/day" type="button" style="margin: 50px" class="btn btn-info">Загально по дням</a>
            <a href="/week" type="button" style="margin: 50px" class="btn btn-info">Загально по тижням</a>
            <a href="/month" type="button" style="margin: 50px" class="btn btn-info">Загально по мiсяцям</a>
        </div>
        <form name="TotalWorkDay" action="" method="GET">
            <table class="table table-sm table-striped table-bordered table-dark">
                <tr class="bg-success">
                    <th>Місяць</th>
                    <th>Нараховано всього</th>
                    <th>Заплатили всього</th>
                    <th>Нараховано CV</th>
                    <th>Готiвка CV</th>
                    <th>Картка CV</th>
                    <th>Нараховано KL</th>
                    <th>Готiвка KL</th>
                    <th>Картка KL</th>
                    <th>Нараховано MG</th>
                    <th>Готiвка MG</th>
                    <th>Картка MG</th>
                </tr>
                <#list totals as total>
                    <tr>
                        <td>${total.month}</td>
                        <td>${total.totalProcedure}</td>
                        <td>${total.totalCashCard}</td>
                        <td>${total.billCV}</td>
                        <td>${total.cashCV}</td>
                        <td>${total.cardCV}</td>
                        <td>${total.billKL}</td>
                        <td>${total.cashKL}</td>
                        <td>${total.cardKL}</td>
                        <td>${total.billMG}</td>
                        <td>${total.cashMG}</td>
                        <td>${total.cardMG}</td>
                    </tr>
                </#list>
            </table>
        </form>
    </div>
</body>
</html>
