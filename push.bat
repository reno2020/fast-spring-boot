rem push remote gh-pages

set m="docs"
echo %m%
if not "%1%"=="" (
    echo "xxxxxxxxxxxxxxxxxx"
    set m=%1;
)
echo %m%
git add .
git commit -m %m%
git push origin refs/heads/gh-pages:gh-pages
