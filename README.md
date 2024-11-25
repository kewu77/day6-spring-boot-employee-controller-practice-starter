GET #obtain a certain specific company with response of id, name\
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Integer id) {
        return companyRepository.getCompanyById(id);
    }
\
\
GET #obtain list of all employee under a certain specific company\
    @GetMapping()
    public Company getCompanyById(@RequestParam Integer companyId) {
        return employeeRepository.getCompanyById(companyId);
    }
\
\
GET #Page query, page equals 1, size equals 5, it will return the data in company list from index 0 to index 4.\
    @GetMapping
    public List<Company> getByPage(@RequestParam Integer page, @RequestParam Integer size){
        return companyRepository.getByPage(page,size);
    }
\
\
PUT # update an employee with company\
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee){
        return employeeRepository.updateByCompanyId(employee);
    }
\
\
POST #add a company\
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company save(@RequestBody Company company){
        return companyRepository.save(company);
    }
\
\
DELETE # delete a company\
    @DeleteMapping("/{id}")
    public Company delete(@PathVariable Integer id){
        return companyRepository.delete(id);
    }