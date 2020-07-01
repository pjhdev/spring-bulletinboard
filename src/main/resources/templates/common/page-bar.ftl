<div class="row">
    <div class="col-sm-12 col-md-5">
        <div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>
    </div>
    <div class="col-sm-12 col-md-7">
        <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
            <ul class="pagination">

                <li class="paginate_button page-item previous" id="dataTable_previous">
                    <a href="/api/v1/board/all?page=${1}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                </li>

                <#if lastPage == 0 >
                    <li class="paginate_button page-item active">
                        <a href="/api/v1/board/all?page=${1}" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">1</a>
                    </li>
                    <#--<button type ="button" onclick="location.href='/api/v1/board/all?page=${1}'">${1}</button>-->
                <#else>
                    <#list 1 .. lastPage as i>
                        <li class="paginate_button page-item active">
                            <a href="/api/v1/board/all?page=${i}" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">${i}</a>
                        </li>
                        <#--<button type ="button" onclick="location.href='/api/v1/board/all?page=${i}'">${i}</button>-->
                    </#list>
                </#if>

                <li class="paginate_button page-item next" id="dataTable_next">
                    <a href="/api/v1/board/all?page=${lastPage}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>