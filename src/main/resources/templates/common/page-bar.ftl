<div class="row">
    <div class="col-sm-12 col-md-5">
        <div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite"></div>
    </div>
    <div class="col-sm-12 col-md-7 right">
        <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
            <ul class="pagination">

                <li class="paginate_button page-item previous" id="dataTable_previous">
                    <a href="/api/v1/board/all?page=${1}" aria-controls="dataTable" class="page-link">처음</a>
                </li>

                <li class="paginate_button page-item previous" id="dataTable_previous">
                    <a href="/api/v1/board/all?page=${startIndex-1}" aria-controls="dataTable" class="page-link">이전</a>
                </li>

                <#if lastPage == 0 >
                    <li class="paginate_button page-item active">
                        <a href="/api/v1/board/all?page=${1}" aria-controls="dataTable" class="page-link">1</a>
                    </li>
                    <#--<button type ="button" onclick="location.href='/api/v1/board/all?page=${1}'">${1}</button>-->
                <#else>
                    <#list startIndex .. endIndex as i>
                        <li class="paginate_button page-item active">
                            <a href="/api/v1/board/all?page=${i}" aria-controls="dataTable" class="page-link">${i}</a>
                        </li>
                    </#list>
                </#if>

                <li class="paginate_button page-item previous" id="dataTable_previous">
                    <#if endIndex == lastPage>
                        <a href="/api/v1/board/all?page=${endIndex}" aria-controls="dataTable" class="page-link">다음</a>
                    <#else>
                        <a href="/api/v1/board/all?page=${endIndex+1}" aria-controls="dataTable" class="page-link">다음</a>
                    </#if>
                </li>
                <li class="paginate_button page-item next" id="dataTable_next">
                    <#if lastPage == 0>
                        <#assign lastPage = 1>
                    </#if>
                    <a href="/api/v1/board/all?page=${lastPage}" aria-controls="dataTable" class="page-link">끝</a>
                </li>
            </ul>
        </div>
    </div>
</div>