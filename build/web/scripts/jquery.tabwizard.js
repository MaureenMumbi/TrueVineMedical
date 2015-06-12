(function($)
{
    var tabWizardMethods = 
    {
        init : function(options) { 
            var $this = this;

            var settings = $.extend(
            {
                tabs: [],
                onClick: function() {}
            }, options);

            $this.addClass('arrowContainer');
            var $tabList = $('<ol>');
            for (var i in settings.tabs)
            {
                var tab = settings.tabs[i];
                var $listItem = $('<li id="' + tab.hash + 'Tab">');
                var $tabLink = $('<a href="#' + tab.hash + '">');
                var $tabLeft = $('<span>&nbsp;</span>').addClass('tabDivider tabLeft');
                var $tabMiddle = $('<span>').addClass('tabMiddle').text(tab.text);
                var $tabRight = $('<span>&nbsp;</span>').addClass('tabDivider tabRight');
        
                if (i == 0)
                    $listItem.addClass('firstItem');
                else if (i == settings.tabs.length - 1)
                    $listItem.addClass('lastItem');
        
                $tabLink
                    .append($tabLeft)
                    .append($tabMiddle)
                    .append($tabRight)
                    .appendTo($listItem);
                $listItem.appendTo($tabList);
            }
            $tabList.appendTo($this);
            return $this;
        },
        setSelected : function(hash)
        {
            $('.tabSelected').removeClass('tabSelected');
            $('#' + hash + 'Tab').addClass('tabSelected');
        }
    };
    $.fn.tabWizard = function(method)
    {
        if (tabWizardMethods[method])
            return tabWizardMethods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        else if ( typeof method === 'object' || ! method )
            return tabWizardMethods.init.apply(this, arguments);
        else
            $.error( 'Method ' +  method + ' does not exist on jQuery.tooltip' );
    }
})(jQuery)